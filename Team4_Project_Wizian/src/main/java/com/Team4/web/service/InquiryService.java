package com.Team4.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.Team4.web.entity.Inquiry;
import com.Team4.web.repository.InquiryRepository;

@Service
public class InquiryService {

    private final InquiryRepository inquiryRepository;

    @Autowired
    public InquiryService(InquiryRepository inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }

	public int getBoardCount(@RequestParam("stud_no") String studNo ) {
		return inquiryRepository.countByStud_no(studNo);
	}

	public List<Inquiry> getAllInquiries() {
        return inquiryRepository.findAll();
    }

    public void saveInquiry(Inquiry inquiry) {
        inquiryRepository.save(inquiry);
    }

    public Inquiry getInquiryById(int inquiryId) {
        return inquiryRepository.findById(inquiryId).orElse(null);
    }
    
 // 상담 완료 메서드 추가
    public void completeConsultation(int inquiryId) {
        Inquiry inquiry = inquiryRepository.findById(inquiryId).orElse(null);
        if (inquiry != null) {
            inquiry.setCSL_STATUS("답변 완료"); // 상담 완료 상태로 변경
            inquiryRepository.save(inquiry);
        }
    }
    
 // 상담사의 답변 저장 메서드 추가
    public void saveResponse(int inquiryId, String response) {
        Inquiry inquiry = inquiryRepository.findById(inquiryId).orElse(null);
        if (inquiry != null) {
            inquiry.setCSL_ANSWER(response);
            inquiryRepository.save(inquiry);
        }
    }

 // 문의 상태 업데이트 메서드 추가
    public void updateInquiryStatus(int inquiryId, String status) {
        Inquiry inquiry = inquiryRepository.findById(inquiryId).orElse(null);
        if (inquiry != null) {
            inquiry.setCSL_STATUS(status);
            inquiryRepository.save(inquiry);
        }
    }

}
