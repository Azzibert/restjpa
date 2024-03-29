package monPaquet;

import java.util.List;
import java.util.UUID;


public interface IBu{

    public void save(Livre livre);
    public void save(Auteur auteur);
    public List<Livre> findAll() ;
    public List<Livre> findByCategorie(String ms) ;
    public void update(Livre livre) ;
    public void deleteById(UUID id ) ;
    public Livre findById(UUID idd) ;
    public void init() ;


}
