package com.vietshop.Service.imp;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vietshop.Service.iProductService;
import com.vietshop.dto.ProductDTO;
import com.vietshop.entity.Category;
import com.vietshop.entity.Product;
import com.vietshop.repository.ProductRepository;

@Service // Để class có thể thực hiện cơ chế DI và IOC
public class ProductService implements iProductService {
	public Page<Product> findLastProduct(String status,Pageable page) {
		return productRepository.findLastProduct(status,page);
	}

	@Autowired
	private ProductRepository productRepository;
	@Override
	public <S extends Product> S save(S entity) {
		return productRepository.save(entity);
	}

	@Override
	public <S extends Product> S findOne(Example<S> example) {
		return productRepository.findOne(example);
	}

	@Override
	public Page<Product> findAllProduct(Pageable pageable) {
		return productRepository.findAllProduct(pageable);
	}

	@Override
	public Page<Product> listRelatedProduct(Long idCategory, Pageable pageable, Long idProduct,String status) {
		return productRepository.listRelatedProduct(idCategory, pageable, idProduct,status);
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> findByIdProduct(Long idProduct) {
		return productRepository.findByIdProduct(idProduct);
	}

	

	@Override
	public Product findOne(Long id) {
		return productRepository.findOne(id);
	}

	@Override
	public Page<Product> findAllByIdCategory(String status,Long idCategory, Pageable pageable) {
		return productRepository.findAllByIdCategory(status,idCategory, pageable);
	}
	
	@Override
	public Page<Product> findAllByIdCategoryAll(Category category, Pageable pageable) {
		return productRepository.findByCategory(category, pageable);
	}

	@Override
	public List<Product> findAll(Sort sort) {
		return productRepository.findAll(sort);
	}

	@Override
	public List<Product> findAll(Iterable<Long> ids) {
		return productRepository.findAll(ids);
	}

	@Override
	public boolean exists(Long id) {
		return productRepository.exists(id);
	}

	@Override
	public <S extends Product> List<S> save(Iterable<S> entities) {
		return productRepository.save(entities);
	}

	@Override
	public void flush() {
		productRepository.flush();
	}

	@Override
	public <S extends Product> S saveAndFlush(S entity) {
		return productRepository.saveAndFlush(entity);
	}

	@Override
	public long count() {
		return productRepository.count();
	}

	@Override
	public void deleteInBatch(Iterable<Product> entities) {
		productRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
		return productRepository.findAll(example, pageable);
	}

	@Override
	public void delete(Long id) {
		productRepository.delete(id);
	}

	@Override
	public void deleteAllInBatch() {
		productRepository.deleteAllInBatch();
	}

	@Override
	public void delete(Product entity) {
		productRepository.delete(entity);
	}

	@Override
	public Product getOne(Long id) {
		return productRepository.getOne(id);
	}

	@Override
	public <S extends Product> long count(Example<S> example) {
		return productRepository.count(example);
	}

	@Override
	public void delete(Iterable<? extends Product> entities) {
		productRepository.delete(entities);
	}

	@Override
	public <S extends Product> List<S> findAll(Example<S> example) {
		return productRepository.findAll(example);
	}

	@Override
	public void deleteAll() {
		productRepository.deleteAll();
	}

	@Override
	public <S extends Product> boolean exists(Example<S> example) {
		return productRepository.exists(example);
	}

	

	 @Override
	public Product get(Long idProduct) {
	        return productRepository.findByIdProduct(idProduct).get();
	    }

	
	

	@Override
	public Page<Product> searchProduct(String keyword,Pageable pageable) {
		return productRepository.searchProduct(keyword,pageable);
	}

	@Override
	public Page<Product> findProducts(String status,Pageable pageable) {
		return productRepository.findProducts(status,pageable);
	}

	@Override
	public <S extends Product> List<S> findAll(long pageIndex, long pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByNameContaining(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Product> findByNameContaining(String name, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDTO> findAllPaging(int pageIndex, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Product> findByIdProduct(long idProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	public void addProduct(ProductDTO productDto) throws Exception, IOException {
		Product product = new Product();
		
		
		
		Category category = new Category();

		category.setIdCategory(productDto.getIdCategory());
		product.setCategory(category);
		// Upload ảnh
//		String saveImgUrl = "/Users/macbook/eclipse-workspace/vietshop/src/main/webapp/resources/images";
		String saveImgUrl = "D:/Java/workspace/vietshop/src/main/webapp/resources/images";

	
			MultipartFile multipartFile = productDto.getImageFile();
			String fileImg = multipartFile.getOriginalFilename();
			File file = new File(saveImgUrl, fileImg);
			multipartFile.transferTo(file);
			productDto.setImgUrl("/resources/images/" + fileImg);// Set đường dẫn lưu trên DB
			
		BeanUtils.copyProperties(productDto, product);
//		product.setSoldQuantity(0L); // set giá trị ban đầu cho soldquantity để hiển thị
//		// Chuyển đổi tiền tệ VNĐ
//		DecimalFormat formatter = new DecimalFormat("###,###,###.##");
//		product.setCost(formatter.format(productDto.getCost())+"đ");

		productRepository.save(product);

	}

	public Page<Product> findTopProduct(String status,Pageable page) {
		return productRepository.findTopProduct(status,page);
	}
	
	public ProductDTO getProductDTO(Long idProduct) {
		Product product = productRepository.getOne(idProduct);
		ProductDTO productDTO = new ProductDTO();
		product.setStatus("display");
		BeanUtils.copyProperties(product, productDTO);
		return productDTO;
	}
	public void changeStatus(ProductDTO productDTO) {
		Product product = new Product();
		BeanUtils.copyProperties(productDTO, product);
		productRepository.save(product);
	}
	
}
	
