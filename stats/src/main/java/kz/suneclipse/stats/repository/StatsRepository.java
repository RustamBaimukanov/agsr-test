package kz.suneclipse.stats.repository;

import kz.suneclipse.stats.model.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Integer> {
}
