package wbs.jdbc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//beim Compilieren werden die annotation in den Bytecode übertragen
//und kann dann zur Laufzeit über reflection-api ausgelesen werden
@Retention(RetentionPolicy.RUNTIME)
// Die Annotation muss vor einem Feld der Klasse positioniert werden
@Target(ElementType.FIELD)
public @interface PrimaryKey {
	int index();
}
