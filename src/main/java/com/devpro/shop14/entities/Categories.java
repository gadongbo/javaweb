package com.devpro.shop14.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity // can dinh nghia de spring-jpa biet.
@Table(name = "tbl_category")
public class Categories extends BaseEntity {
	@Column(name = "name", length = 100, nullable = false)
	private	String name;
	
	@Column(name = "description", length = 100, nullable = false)
	private	String description;
	
	@Column(name = "seo", length = 1000, nullable = true)
	private	String seo;

	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "categories")
	private Set<Product> products = new HashSet<Product>();

	/**
	 * them  1 san pham vao danh sach @OneToMany
	 * @param product
	 */
	public void addRelationProduct(Product product) {
		products.add(product);
		product.setCategories(this);
	}

	/**
	 * xoa san pham khoi danh sach @OneToMany
	 * @param product
	 */
	public void deleteRelationProduct(Product product) {
		products.remove(product);
		product.setCategories(null);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	
	
}
