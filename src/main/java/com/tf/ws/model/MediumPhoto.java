package com.tf.ws.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Heather
 * Date: 6/13/2014
 *
 * Models a medium sized photograph.
 */
@Document
public class MediumPhoto implements Serializable {

	private static final long serialVersionUID = 506517339337225071L;

	@Id
	private String id;

	private String photoId;
	private byte[] photoContent;
	private String photoType;

	private int width;
	private int height;

    public MediumPhoto() {
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhotoId()
	{
		return photoId;
	}

	public void setPhotoId(String photoId)
	{
		this.photoId = photoId;
	}

	public byte[] getPhotoContent() {
        return photoContent;
    }

    public void setPhotoContent(byte[] photoContent) {
        this.photoContent = photoContent;
    }

	public String getPhotoType() {
		return photoType;
	}

	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}
}
