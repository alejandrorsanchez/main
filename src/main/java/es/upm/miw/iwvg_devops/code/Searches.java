package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;

public class Searches {

    public Fraction findFractionAdditionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> id.equals(user.getId()))
                .flatMap(user -> user.getFractions().stream())
                .reduce(new Fraction(0, 1), (acumulator, element) -> acumulator.add(element));
    }

    public Double findFirstDecimalFractionByUserName(String name){
        return new UsersDatabase().findAll()
                .filter(user -> name.equals(user.getName()))
                .flatMap(user -> user.getFractions().stream())
                .findFirst().orElseThrow().decimal();

    }

    public Stream findUserFamilyNameByAllNegativeSignFractionDistinct(){
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fraction.isNegative()))
                .distinct()
                .map(User::getFamilyName);
    }

    public Stream findUserFamilyNameByImproperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fraction.isNoProper()))
                .map(User::getFamilyName);
    }

}
