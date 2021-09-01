package com.everis.d4i.tutorial.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.d4i.tutorial.entities.Chapter;
import com.everis.d4i.tutorial.exceptions.NetflixException;
import com.everis.d4i.tutorial.exceptions.NotFoundException;
import com.everis.d4i.tutorial.json.ChapterRest;
import com.everis.d4i.tutorial.repositories.ChapterRepository;
import com.everis.d4i.tutorial.services.ChapterService;
import com.everis.d4i.tutorial.utils.constants.ExceptionConstants;

@Service
public class ChapterServiceImpl implements ChapterService {

	@Autowired
	private ChapterRepository chapterRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<ChapterRest> getChaptersByTvShowIdAndSeasonNumber(Long tvShowId, short seasonNumber)
			throws NetflixException {
		return chapterRepository.findBySeasonTvShowIdAndSeasonNumber(tvShowId, seasonNumber).stream()
				.map(chapter -> modelMapper.map(chapter, ChapterRest.class)).collect(Collectors.toList());
	}

	@Override
	public ChapterRest getChapterByTvShowIdAndSeasonNumberAndChapterNumber(Long tvShowId, short seasonNumber,
			short chapterNumber) throws NetflixException {
		Chapter chapter = chapterRepository
				.findBySeasonTvShowIdAndSeasonNumberAndNumber(tvShowId, seasonNumber, chapterNumber)
				.orElseThrow(() -> new NotFoundException(ExceptionConstants.MESSAGE_INEXISTENT_CHAPTER));
		return modelMapper.map(chapter, ChapterRest.class);
	}

	@Override
	public ChapterRest updateChapterName(Long chapterId, String name) throws NetflixException {
		
		//Buscamos el capitulo por su ID
		Optional<Chapter> chapter = chapterRepository.findById(chapterId);
		
		//Creamos la nueva entidad que queremos actualizar y guardamos
		//para que se persistan los cambios
		Chapter chapterNew= chapter.get();
		chapterNew.setName(name);
		chapterRepository.save(chapterNew);
		
		return null;
	}

}
