package com.everis.d4i.tutorial.services.impl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.d4i.tutorial.entities.Category;
import com.everis.d4i.tutorial.entities.TvShow;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.TvShowRest;
import com.everis.d4i.tutorial.repositories.CategoryRepository;
import com.everis.d4i.tutorial.repositories.TvShowRepository;
import com.everis.d4i.tutorial.services.TvShowService;


@Service
public class TvShowServiceImpl implements TvShowService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TvShowServiceImpl.class);

	
	@Autowired
	private TvShowRepository tvShowRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	private ModelMapper modelMapper = new ModelMapper();

	
	/*public List<TvShowRest> getTvShowsByCategory(Long categoryId) throws NetflixException {

		return tvShowRepository.findByCategoryId(categoryId).stream()
				.map(tvShow -> modelMapper.map(tvShow, TvShowRest.class)).collect(Collectors.toList());

	}*/

	@Override
	public TvShowRest getTvShowById(Long id) throws NetflixException {

		try {
			return modelMapper.map(tvShowRepository.getById(id), TvShowRest.class);
		} catch (EntityNotFoundException entityNotFoundException) {
			throw new NotFoundException(entityNotFoundException.getMessage());
		}

	}


	@Override
	 public TvShowRest updateTvShow(Long id, String name)throws NetflixException {
		
			
			Optional<TvShow> tvShow = tvShowRepository.findById(id);
			
			if(tvShow.isPresent()) { 
			TvShow tvShowNew= tvShow.get();
			
			tvShowNew.setName(name);
			tvShowRepository.save(tvShowNew);
			}
			try {
				return modelMapper.map(tvShowRepository.getById(id), TvShowRest.class);
			} catch (EntityNotFoundException entityNotFoundException) {
				throw new NotFoundException(entityNotFoundException.getMessage());
			}
			
	}


	@Override
	public TvShowRest addCategoryToTvShow(Long idTvShow, Long idCategory) throws NetflixException {
			
			Optional<TvShow> tvShow = tvShowRepository.findById(idTvShow);
			
			if(tvShow.isPresent()) {
			TvShow tvShowNew= tvShow.get();
			
			Optional<Category> category = categoryRepository.findById(idCategory);
			Category categoryNew= category.get();
			
			tvShowNew.getCategories().add(categoryNew);
		
			tvShowRepository.save(tvShowNew);
			
			}
		return modelMapper.map(tvShowRepository.findById(idTvShow), TvShowRest.class );
	}


	@Override
	public TvShowRest deleteTvShow(Long idTvShow) throws NetflixException {
		
			Optional<TvShow> tvShow = tvShowRepository.findById(idTvShow);
			if(tvShow.isPresent()) {
				tvShowRepository.deleteById(tvShow.get().getId());
			}

		return modelMapper.map(tvShowRepository.findById(idTvShow), TvShowRest.class );
	}


}