package com.ey.donna.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ey.donna.model.HSupplyPhotos;
import com.ey.donna.model.HUpload;

public class SupplyPhotosMapper extends BaseMapper implements RowMapper<HSupplyPhotos> {

    public HSupplyPhotos mapRow(ResultSet rs, int rowNum) throws SQLException {

	HSupplyPhotos ob = new HSupplyPhotos();

	int colindex = 0;

	colindex = findColumn(rs, "sid");
	if (colindex > 0) {
	    ob.setSid(rs.getString(colindex));
	}
	
	colindex = findColumn(rs, "link");
	if (colindex > 0) {
	    HUpload obj = new HUpload();
	    int id = rs.getInt("link");
	    obj.setId(id);
	    String link = rs.getString("link");
	    if (null != link)
		obj.setPath(link);
	    else
		obj.setPath("");
	    int length = rs.getInt("length");
	    obj.setLength(length);
	    String name = rs.getString("name");
	    obj.setName(name);
	    String sname = rs.getString("saveName");
	    obj.setSaveName(sname);
	    String type = rs.getString("type");
	    obj.setType(type);
	    String path = rs.getString("path");
	    obj.setPath(path);
	    
	    ob.setLink(obj);
	}

	return ob;
    }

}
