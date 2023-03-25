package util;


import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Consequence;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.ArrayList;
import java.util.List;

import static util.Hooks.driver;


public class ActorFactory{


    public static Actor crearYRegistrarActor(String actorNombre, String actorDescripcion, List<Ability> actorHabilidades) {


        Actor actor = Actor.named(actorNombre).describedAs(actorDescripcion);

        actorHabilidades = new ArrayList<>(actorHabilidades);
        for(Ability ability : actorHabilidades) {
            actor.can(ability);
        }

        OnStage.theActorCalled(actorNombre).describedAs(actorDescripcion).whoCan(BrowseTheWeb.with(driver));
        return actor;


    }




}
