package lab.mon.actlab.java.reflect;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import lab.mon.actlab.R;
import lab.mon.actlab.java.reflect.construct.ConstructorTroubleAgain;
import lab.mon.actlab.java.reflect.construct.ConstructorTroubleToo;
import lab.mon.actlab.java.reflect.construct.RestoreAliases;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

//ReflectActivity annotation
@Deprecated
public class ReflectActivity<T, V> extends AppCompatActivity implements View.OnClickListener {

    public int reflectInt = 1;

    public Integer reflectObjectInt = Integer.valueOf(1);

    public HashSet<String> reflectSet = new HashSet<String>();

    static Object reflectObject = new Object() {
        public void m() {
        }
    };

    @Override
    public void onClick(View v) {

    }

    public enum REFLECTENUM {
        FIRST, SECEND
    }

    private interface ReflectInter {
        void getString();
    }

    class ReFelctInner {

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflect);
    }


    @Override
    protected void onResume() {
        super.onResume();
        getReflect();
        getAllMember();
        getDeclaredMember();
        getDeclaredclass();
//        ClassDeclarationSpy spy =new ClassDeclarationSpy();
//        spy.ClassDeclarationSpy("lab.mon.actlab.java.reflect.ReflectActivity","lab.mon.actlab.MainActivity");
//        ClassSpy classSpy =new ClassSpy();
//        classSpy.classSpy("lab.mon.actlab.java.reflect.ReflectActivity",ClassMember.ALL.name());
//        FieldSpy fieldSpy =new FieldSpy();
//        fieldSpy.fieldSpy("lab.mon.actlab.java.reflect.FieldSpy","b");
//        FieldModifierSpy fieldModifierSpy =new FieldModifierSpy();
//        fieldModifierSpy.fieldModifierSpy(FieldModifierSpy.class.getName(),"voiatile");
//        fieldModifierSpy.fieldModifierSpy(Spy.class.getName(),"public");
//        fieldModifierSpy.fieldModifierSpy(FieldModifierSpy.Inner.class.getName(),"final");
//        fieldModifierSpy.fieldModifierSpy(Spy.class.getName(),"private","static","final");
//          Book book =new Book();
//          book.main();
//        MethodSpy methodSpy = new MethodSpy();
//        methodSpy.main("java.lang.Class","getConstructor");
//        methodSpy.main("java.lang.Class","cast");
//        MethodParameterSpy methodParameterSpy =new MethodParameterSpy();
//        methodParameterSpy.main(ExampleMethods.class.getCanonicalName());
//        MethodModifierSpy methodModifierSpy =new MethodModifierSpy();
//        methodModifierSpy.main("java.lang.String","compareTo");
//        Deet deet = new Deet();
//        deet.main(Deet.class.getCanonicalName(),"ja", "JP", "JP");
//        deet.main(Deet.class.getCanonicalName(),"xx", "XX", "XX");
//        InvokeMain invokeMain = new InvokeMain();
//        invokeMain.main( Deet.class.getCanonicalName(),Deet.class.getCanonicalName(), "ja", "JP", "JP");
//        ReflectMain reflectMain = new ReflectMain();
//        reflectMain.reflectinterMain();
//        ConstructorSift constructorSift = new ConstructorSift();
//        constructorSift.main("java.util.Formatter", "java.util.Locale");
//        constructorSift.main("java.lang.String", "[C");
//        ConstructorAccess constructorAccess = new ConstructorAccess();
//        constructorAccess.main("java.io.File","private");
//        RestoreAliases restoreAliases = new RestoreAliases();
//        restoreAliases.main();
//        ConstructorTroubleToo.main();
//        ConstructorTroubleAgain.main();
//        ConstructorTroubleAgain.main("int");
        ConstructorTroubleAgain.main("Object");

        try {
            getFiledClass();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    public Class getReflect() {
        boolean isable = false;
        Set<String> setReflect = new HashSet<>();
        Class z = java.util.HashSet.class;
        return setReflect.getClass();
    }

    ///获取当前类以及继承类的类，接口，枚举，publi
    public Class<?>[] getAllMember() {
        Class<?>[] classes = lab.mon.actlab.java.reflect.ReflectActivity.class.getClasses();
        return classes;
    }

    ///获取当前类的类，接口，枚举，pulbic 和private
    public Class<?>[] getDeclaredMember() {
        Class<?>[] classes = lab.mon.actlab.java.reflect.ReflectActivity.class.getDeclaredClasses();
        return classes;
    }

    ///如果当前的类或者接口是一个在一个类中声明，则拿到声明它的类
    public Class getDeclaredclass() {
        Class classes = lab.mon.actlab.java.reflect.ReflectActivity.ReFelctInner.class.getDeclaringClass();
        return classes;
    }

    ///获取声明当前字段的类
    public Class getFiledClass() throws NoSuchFieldException {
        Field f = lab.mon.actlab.java.reflect.ReflectActivity.class.getField("reflectObjectInt");
        return f.getDeclaringClass();
    }

    //匿名类获取


}
