//zakladamy ze zawsze wejsciem metody bedzie zbior producentow

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//Zadanie 26a.
//
//Wykorzystując mechanizmy programowania funkcyjnego na podstawie zadanej struktury wyświetl:
//
//    listę wszystkich Modelów,
//    listę wszystkich aut,
//    listę wszystkich nazw producentów,
//    listę wszystkich lat założenia producentów,
//    listę wszystkich nazw modeli,
//    listę wszystkich lat startu produkcji modeli,
//    listę wszystkich nazw aut,
//    listę wszystkich opisów aut,
//    tylko modele z parzystym rokiem startu produkcji,
//    tylko auta producentów z parzystym rokiem założenia,
//    tylko auta z parzystym rokiem startu produkcji modelu oraz nieparzystym rokiem założenia producenta,
//    tylko auta typu CABRIO z nieparzystym rokiem startu produkcji modelu i parzystym rokiem założenia producenta,
//    tylko auta typu SEDAN z modelu nowszego niż 2019 oraz rokiem założenia producenta mniejszym niż 1919.
public class CarMethods {

    //1
    public List<Model> getAllModels(Set<Manufacturer> manufacturers){
        //najpierw tworzymy strumien, teraz w strumieniu mamy poszczegolnych producentow
        return manufacturers.stream()
                //flatMap "splaszcza" strumien, w tym przypadku:
                //wyrazenie lambda przyjmuje pojedynczego producenta a nastepnie zwraca strumien modeli
                //nastepnie strumienie modeli sa laczone w jeden strumien za pomoca metody flatMap()
                .flatMap(m->m.models.stream()) //flatMap laczy strumienie w jeden strumien
                .collect(Collectors.toList()); //składamy modele do listy, ktora jest zwracana z metody
    }

    //2
    public List<Car> getAllCars(Set<Manufacturer> manufacturers){
        return manufacturers.stream()
                .flatMap(m->m.models.stream()) //mamy teraz w strumieniu modele
                .flatMap(m->m.cars.stream()) //teraz dostalismy az do samochodow
                .collect(Collectors.toList());
    }

}
