package com.scaleupindia.service.impl;

import java.util.Objects;

import com.scaleupindia.config.PropertiesConfig;
import com.scaleupindia.dto.OwnerDTO;
import com.scaleupindia.entity.Owner;
import com.scaleupindia.exceptions.OwnerAlreadyExistsException;
import com.scaleupindia.exceptions.OwnerNotFoundException;
import com.scaleupindia.repository.OwnerRepository;
import com.scaleupindia.repository.impl.OwnerRepositoryImpl;
import com.scaleupindia.service.OwnerService;
import com.scaleupindia.util.MapperUtil;

public class OwnerServiceImpl implements OwnerService{
     private static OwnerRepository ownerRepository;
     private static final String OWNER_ALREADY_EXISTS = "owner.already.exists";
 	private static final String OWNER_NOT_FOUND = "owner.not.found";
 	private static final PropertiesConfig PROPERTIES_CONFIG = PropertiesConfig.getInstance();
     
     public OwnerServiceImpl() {
    	 ownerRepository = new OwnerRepositoryImpl();
     }
	@Override
	public void saveOwner(OwnerDTO ownerDTO) throws OwnerAlreadyExistsException {
		Owner existingOwner = ownerRepository.findOwner(ownerDTO.getId());
		if (Objects.nonNull(existingOwner)) {
			throw new OwnerAlreadyExistsException(
					String.format(PROPERTIES_CONFIG.getProperty(OWNER_ALREADY_EXISTS), ownerDTO.getId()));
		}
		Owner owner = MapperUtil.convertOwnerDtoToEntity(ownerDTO);
		ownerRepository.saveOwner(owner);
		
	}

	@Override
	public OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException {
		Owner existingOwner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(existingOwner)) {
			throw new OwnerNotFoundException(
					String.format(PROPERTIES_CONFIG.getProperty(OWNER_NOT_FOUND), ownerId));
		}
		OwnerDTO ownerDTO = MapperUtil.convertOwnerEntityToDto(existingOwner);
		return ownerDTO;
	}

	@Override
	public void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException {
		Owner existingOwner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(existingOwner)) {
			throw new OwnerNotFoundException(
					String.format(PropertiesConfig.getProperty(OWNER_NOT_FOUND), ownerId));
		}
		ownerRepository.updatePetDetails(ownerId, petName);
		
	}

	@Override
	public void deleteOwner(int ownerId) throws OwnerNotFoundException {
		Owner existingOwner = ownerRepository.findOwner(ownerId);
		if (Objects.isNull(existingOwner)) {
			throw new OwnerNotFoundException(
					String.format(PropertiesConfig.getProperty(OWNER_NOT_FOUND), ownerId));
		}
		ownerRepository.deleteOwner(ownerId);
		
	}

}
