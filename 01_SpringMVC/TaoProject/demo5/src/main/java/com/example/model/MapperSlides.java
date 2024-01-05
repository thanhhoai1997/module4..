package com.example.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperSlides implements RowMapper<Slides> {

    /**
     * Implementations must implement this method to map each row of data
     * in the ResultSet. This method should not call {@code next()} on
     * the ResultSet; it is only supposed to map values of the current row.
     *
     * @param rs     the ResultSet to map (pre-initialized for the current row)
     * @param rowNum the number of the current row
     * @return the result object for the current row (may be {@code null})
     * @throws SQLException if an SQLException is encountered getting
     *                      column values (that is, there's no need to catch SQLException)
     */
    @Override
    public Slides mapRow(ResultSet rs, int rowNum) throws SQLException {
        Slides slides = new Slides();
        slides.setId(rs.getInt("id"));
        slides.setImg(rs.getString("img"));
        slides.setCaption(rs.getString("caption"));
        slides.setContent(rs.getString("content"));
        return slides;
    }
}
