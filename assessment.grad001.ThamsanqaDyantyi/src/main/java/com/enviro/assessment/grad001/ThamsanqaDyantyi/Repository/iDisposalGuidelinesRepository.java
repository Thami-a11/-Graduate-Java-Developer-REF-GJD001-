package com.enviro.assessment.grad001.ThamsanqaDyantyi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enviro.assessment.grad001.ThamsanqaDyantyi.model.DisposalGuidelines;

@Repository
public interface iDisposalGuidelinesRepository extends JpaRepository<DisposalGuidelines, Long> {

}
