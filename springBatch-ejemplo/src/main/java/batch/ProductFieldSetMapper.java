package batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import domain.Product;

public class ProductFieldSetMapper implements FieldSetMapper<Product> {

	public Product mapFieldSet(FieldSet fieldSet) throws BindException {
		Product product = new Product();
		product.setId(fieldSet.readString("PRODUCT_ID"));
		product.setName(fieldSet.readString("NAME"));
		product.setPrice(fieldSet.readBigDecimal("PRICE"));
		product.setDescription(fieldSet.readString("DESCRIPTION"));
		
		return product;
	}

}
