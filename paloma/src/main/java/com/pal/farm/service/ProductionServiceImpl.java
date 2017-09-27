//package com.pal.farm.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.omg.CosNaming.NamingContextPackage.NotFound;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import com.pal.farm.dao.ProductionDAO;
//import com.pal.farm.dto.ProductionDTO;
//import com.pal.farm.mappers.ProductionMapperService;
//
//import com.pal.farm.model.Production;
//
//@Service
//public class ProductionServiceImpl implements ProductionService {
//
//	@Autowired
//	private ProductionMapperService productionMapper;
//	
//	@Autowired
//	private ProductionDAO productionDao;
//
//	@Override
//	public ProductionDTO create(ProductionDTO t) {
//		return productionMapper.map(productionDao.save( productionMapper.map(t) ));
//	}
//
//	@Override
//	public void delete(ProductionDTO t, Integer id) {
//		final Production p = productionMapper.map(t);
//		p.setIdProduction(id);
//		productionDao.delete(p); 
//	}
//
//	@Override
//	public ProductionDTO update(ProductionDTO t, Integer id) {
//		final Production p = productionMapper.map(t);
//		p.setIdProduction(id);
//		return productionMapper.map( productionDao.save(p) );
//	}
//	
//	@Override
//	public List<ProductionDTO> getAll(Pageable pageable) {
//		final List<ProductionDTO> productions = new ArrayList<>();
//		productionDao.findAll(pageable).forEach(p -> productions.add( productionMapper.map(p)));
//		return productions;
//	}
//
//	@Override
//	public ProductionDTO findById(Integer id) {
//		return productionMapper.map( productionDao.findOne(id) );
//	}
//
//}