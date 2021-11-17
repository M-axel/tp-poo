import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface miageBasics {
    public String nom() default "MAISSA";
    public String prenom() default "Axel";
    public int annee() default 2021;
    public String module() default "";
    public int td() default 1;
}
