/*
 *
 * Copyright 2013-2016 Pacific Coast Professional Services, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tf.ws.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tf.ws.errors.UserNotFoundException;
import com.tf.ws.model.ClientErrorInformation;
import com.tf.ws.model.WebUser;
import com.tf.ws.model.WebUserSummary;
import com.tf.ws.service.WebUserService;

// @RestController
public class UserController {
	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private WebUserService webUserService;

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebUser> getUser(@PathVariable("id") String id) throws UserNotFoundException  {

		WebUser webUser =  webUserService.getUserById(id);

		if (webUser == null) {
			throw new UserNotFoundException();
		}

		return new ResponseEntity<>(webUser, HttpStatus.OK);
    }

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<WebUserSummary>> getUsers() {

		List<WebUserSummary> webUserSummaries = new ArrayList<>();
		List<WebUser> webUsers = webUserService.findUsers();

		for (WebUser webUser: webUsers) {
			webUserSummaries.add(convertToSummary(webUser));
		}

		return new ResponseEntity<>(webUserSummaries, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/check/{userName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WebUserSummary> checkUser(@PathVariable("userName") String userName) {
		WebUserSummary webUserSummary = new WebUserSummary();

		WebUser webUser = webUserService.getUserByUserName(userName);
		if (webUser != null) {
			webUserSummary.setUserName(webUser.getUserName());
		}

		return new ResponseEntity<>(webUserSummary, HttpStatus.OK);
	}

	@RequestMapping(value="/users", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<WebUserSummary> addNewUser(@RequestBody WebUserSummary webUserSummary) {
		WebUser webUser = convertFromSummary(webUserSummary);
		webUserService.addUser(webUser);
		return new ResponseEntity<>(convertToSummary(webUserService.getUserByUserName(webUser.getUserName())), HttpStatus.OK);
	}

	@RequestMapping(value="/users", method=RequestMethod.OPTIONS)
	public String allowed()
	{
		return "GET, POST, OPTIONS, HEAD";
	}

	private WebUser convertFromSummary(WebUserSummary webUserSummary) 	{
		WebUser webUser = new WebUser();
		webUser.setId(webUserSummary.getId());
		webUser.setUserName(webUserSummary.getUserName());
		webUser.setFirstName(webUserSummary.getFirstName());
		webUser.setLastName(webUserSummary.getLastName());
		webUser.setEmailAddress(webUserSummary.getEmailAddress());

		return webUser;
	}

	private WebUserSummary convertToSummary(WebUser webUser) {
		WebUserSummary webUserSummary = new WebUserSummary();
		webUserSummary.setId(webUser.getId());
		webUserSummary.setUserName(webUser.getUserName());
		webUserSummary.setFirstName(webUser.getFirstName());
		webUserSummary.setLastName(webUser.getLastName());
		webUserSummary.setEmailAddress(webUser.getEmailAddress());

		return webUserSummary;
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ClientErrorInformation> noSuchUserFound(HttpServletRequest req, Exception e) {
		ClientErrorInformation error = new ClientErrorInformation(e.getMessage(), req.getRequestURI());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
