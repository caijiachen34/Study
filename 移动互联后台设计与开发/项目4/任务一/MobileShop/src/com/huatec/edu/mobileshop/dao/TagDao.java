package com.huatec.edu.mobileshop.dao;

import java.util.List;

import com.huatec.edu.mobileshop.entity.Tag;

public interface TagDao {
	public int save(Tag tag);
	public int deleteById(int tag_id);
	public List<Tag> findAll();
	public Tag findById(int tag_id);
	public int dynamicUpdate(Tag tag);
}
