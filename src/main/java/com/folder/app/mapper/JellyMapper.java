package com.folder.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.folder.app.dto.JellyDTO;

@Mapper
public interface JellyMapper{

  @Select("select * from jelly_info")
  public List<JellyDTO> jellyFindAll();

}