import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface miageAdvanced {
    enum etat {
        draft_partiel,
        draft_complet,
        final,
    }

    public Enum etat() default ;
    public String prenom() default "Axel";
    public int annee() default 2021;
    public String module() default "";
    public int td() default 1;
}
