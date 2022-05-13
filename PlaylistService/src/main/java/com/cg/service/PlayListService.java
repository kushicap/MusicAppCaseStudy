package com.cg.service;

import java.util.List;

import com.cg.exception.DeletedAlreadyExistsException;
import com.cg.exception.PlayListsAlreadyExistsException;
import com.cg.model.PlayList;


public interface PlayListService {
	public PlayList addPlayList(PlayList playlist) throws PlayListsAlreadyExistsException;
	public List<PlayList> getAllPlayList();
	public void deletePlayListByid(String id) throws DeletedAlreadyExistsException ;
}
