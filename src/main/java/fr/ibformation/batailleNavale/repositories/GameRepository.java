package fr.ibformation.batailleNavale.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.ibformation.batailleNavale.models.Game;

public interface GameRepository extends CrudRepository<Game, Long>{

}
