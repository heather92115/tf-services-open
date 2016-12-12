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

import java.util.List;

import com.tf.ws.model.KnownBad;

/**
 * Stores and retrieves known bad ip addresses to and from database.
 *
 * @author  Heather Stevens
 */
public interface KnownBadRepository
{
	void saveKnownBad(KnownBad knownBad);
	void removeKnownBad(String knownBadId);
	KnownBad getKnownBadById(String knownBadId);
	KnownBad getKnownBadByRemoteAddress(String remoteAddress);
	List<KnownBad> findAllKnownBad();
}