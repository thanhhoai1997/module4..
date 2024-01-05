package com.example.dto;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDtopMapper implements RowMapper<ProductDto> {
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
    public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductDto productDto = new ProductDto();
        productDto.setId_product(rs.getLong("id_product"));
        productDto.setId_category(rs.getInt("id_category"));
        productDto.setSizes(rs.getString("sizes"));
        productDto.setName(rs.getString("name"));
        productDto.setPrice(rs.getDouble("price"));
        productDto.setSale(rs.getInt("sale"));
        productDto.setTitle(rs.getString("title"));
        productDto.setHighlight(rs.getBoolean("highlight"));
        productDto.setNew_product(rs.getBoolean("new_product"));
        productDto.setDetails(rs.getString("details"));
        productDto.setId_color(rs.getLong("id_color"));
        productDto.setName_color(rs.getString("name_color"));
        productDto.setCode_color(rs.getString("code_color"));
        productDto.setImg(rs.getString("img"));
        productDto.setCreated_at(rs.getDate("created_at"));
        productDto.setUpdated_at(rs.getDate("updated_at"));

        return productDto;
    }
}
