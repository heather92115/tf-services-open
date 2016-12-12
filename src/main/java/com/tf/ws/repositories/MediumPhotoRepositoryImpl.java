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
package com.tf.ws.repositories;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.tf.ws.model.MediumPhoto;

/**
 * Saves and retrieves medium sized photos from/to database.
 *
 * @author Heather Stevens on 6/13/2014
 */
@Repository("mediumPhotoRepository")
public class MediumPhotoRepositoryImpl implements MediumPhotoRepository, Serializable
{
	private static final long serialVersionUID = 3156042260185155339L;
	@Autowired
	protected MongoTemplate mongoTemplate;

	public MediumPhotoRepositoryImpl() {
	}

	@Override
	public MediumPhoto getMediumPhotoById(String mediumPhotoId)
	{
		return mongoTemplate.findById(mediumPhotoId, MediumPhoto.class);
	}

	@Override
	public void saveMediumPhoto(MediumPhoto mediumPhoto)
	{
		mongoTemplate.save(mediumPhoto);
	}

	@Override
	public void removeMediumPhoto(String mediumPhotoId) {
		Query query = new Query(Criteria.where("id").is(mediumPhotoId));
		mongoTemplate.remove(query, MediumPhoto.class);
	}
}
