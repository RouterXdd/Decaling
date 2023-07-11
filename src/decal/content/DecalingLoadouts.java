package decal.content;

import mindustry.game.*;

public class DecalingLoadouts {
    public static Schematic basicDrillCore, basicBorn, basicReturn
            ;

    public static void load(){
        basicDrillCore = Schematics.readBase64("bXNjaAF4nGNgZmBmZmDJS8xNZeB0zi9KtVJwKapk4E5JLU4uyiwoyczPY2BgYMtJTErNKWZgio5lZOBLSU1OzNFNBirWTQGqZWBgBCEgBADe6xIK");
        basicBorn = Schematics.readBase64("bXNjaAF4nB3KwQmAMAwF0B8VQXpwki7RNcRDmuYQqKm07o/oOz8QaMbifCm2xMMkte4IRYd0ux9rDmCtnLUOTMdJ2IsK1yita8xfBgg/egELERLI");
        basicReturn = Schematics.readBase64("bXNjaAF4nGNgZmBmZmDJS8xNZeB2SizOTA5KLSktymPgTkktTi7KLCjJzM9jYGBgy0lMSs0pZmCKjmVkEExJTU7M0U3OL0rVLYIoZ2BgBCEgAQCAnRSv");
    }
}
