package com.ayaagroup.demo.Services;

import com.ayaagroup.demo.dto.AllLostDto;
import com.ayaagroup.demo.dto.LostDto;
import com.ayaagroup.demo.entity.ContactUs.LostCard;
import com.ayaagroup.demo.repository.LostCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LostService {
    @Autowired
    private LostCardRepo lostCardRepo;

    public LostDto lostCard (LostCard lost){
        return LostDto.toDto(lostCardRepo.save(lost));
    }

    public LostDto retrieveLostCardInfo(Integer requestId) {
        Optional<LostCard> lostCard = lostCardRepo.findById(requestId);
        if (lostCard.isPresent()){
            return LostDto.toDto(lostCard.get());
        }
        else return null;
    }

    public List<AllLostDto> getAllLostCardRequests(){
        return this.lostCardRepo.getAllLostCards();
    }
}
