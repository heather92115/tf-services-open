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

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tf.ws.errors.PhotoNotFoundException;
import com.tf.ws.model.ClientErrorInformation;
import com.tf.ws.model.LargePhoto;
import com.tf.ws.model.MediumPhoto;
import com.tf.ws.model.Photo;
import com.tf.ws.service.ImageService;

@RestController
public class PhotoController {
	private final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private ImageService imageService;

	@RequestMapping(value = "/photos/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<InputStreamResource> getPhotoContent(@PathVariable("id") String id) throws PhotoNotFoundException  {
		Photo photo = imageService.getPhotoById(id);

		if (photo == null) {
			throw new PhotoNotFoundException();
		}

		return ResponseEntity.ok()
				.contentLength(photo.getPhotoContent().length)
				.contentType(MediaType.parseMediaType(photo.getPhotoType()))
				.body(new InputStreamResource(new ByteArrayInputStream(photo.getPhotoContent())));
	}

	@RequestMapping(value = "/photos/large/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<InputStreamResource> getLargePhotoContent(@PathVariable("id") String id) throws PhotoNotFoundException  {
		LargePhoto largePhoto = imageService.getLargePhotoById(id);

		if (largePhoto == null) {
			throw new PhotoNotFoundException();
		}

		return ResponseEntity.ok()
				.contentLength(largePhoto.getPhotoContent().length)
				.contentType(MediaType.parseMediaType(largePhoto.getPhotoType()))
				.body(new InputStreamResource(new ByteArrayInputStream(largePhoto.getPhotoContent())));
	}

	@RequestMapping(value = "/photos/medium/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<InputStreamResource> getMediumPhotoContent(@PathVariable("id") String id) throws PhotoNotFoundException  {
		MediumPhoto mediumPhoto = imageService.getMediumPhotoById(id);

		if (mediumPhoto == null) {
			throw new PhotoNotFoundException();
		}

		return ResponseEntity.ok()
				.contentLength(mediumPhoto.getPhotoContent().length)
				.contentType(MediaType.parseMediaType("image/jpeg"))
				.body(new InputStreamResource(new ByteArrayInputStream(mediumPhoto.getPhotoContent())));
	}

	@RequestMapping(value = "/photos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Photo>> getPhotos() {

		List<Photo> photoList = imageService.findPhotos();

		return new ResponseEntity<>(photoList, HttpStatus.OK);
	}

	@RequestMapping(value="/photos", method=RequestMethod.OPTIONS)
	public String allowed()
	{
		return "GET, OPTIONS, HEAD";
	}

	@ExceptionHandler(PhotoNotFoundException.class)
	public ResponseEntity<ClientErrorInformation> noSuchPhotoFound(HttpServletRequest req) {
		ClientErrorInformation error = new ClientErrorInformation("No such photo with specified id.", req.getRequestURI());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
