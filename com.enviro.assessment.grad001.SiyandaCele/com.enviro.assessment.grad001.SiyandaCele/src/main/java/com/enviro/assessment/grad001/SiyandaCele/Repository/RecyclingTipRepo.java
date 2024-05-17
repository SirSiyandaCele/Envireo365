package com.enviro.assessment.grad001.SiyandaCele.Repository;

import com.enviro.assessment.grad001.SiyandaCele.model.RecyclingTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecyclingTipRepo extends JpaRepository<RecyclingTip,Long> {
}
