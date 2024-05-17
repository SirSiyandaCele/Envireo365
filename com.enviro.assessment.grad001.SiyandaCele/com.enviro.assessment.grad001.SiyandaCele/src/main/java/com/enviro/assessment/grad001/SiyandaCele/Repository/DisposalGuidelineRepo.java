package com.enviro.assessment.grad001.SiyandaCele.Repository;

import com.enviro.assessment.grad001.SiyandaCele.model.DisposalGuideline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisposalGuidelineRepo extends JpaRepository<DisposalGuideline, Long> {
}
