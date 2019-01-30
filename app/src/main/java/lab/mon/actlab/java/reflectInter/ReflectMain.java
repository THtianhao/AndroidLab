package lab.mon.actlab.java.reflectInter;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ReflectMain {
    Class<?> obs = null;
    InterProxy.ProxyCallback callback = new InterProxy.ProxyCallback() {
        @Override
        public void onInvoke() {
            Log.d("totolog", "invokeSuccess");
        }
    };

    public void reflectinterMain() {


        try {
            Class<?> reflectClass = Class.forName(ReflectClass.class.getName());
            obs = Class.forName(ReflectClass.ReflectInter.class.getName());
            Method method = reflectClass.getDeclaredMethod("addInter", obs);
            Object listener = Proxy.newProxyInstance(obs.getClassLoader(), new Class[]{obs}, new InterProxy(callback));
            method.setAccessible(true);
            Object classObject = reflectClass.newInstance();
            method.invoke(classObject, new Object[]{listener});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


}

class InterProxy implements InvocationHandler {
    public ProxyCallback callback = null;

    interface ProxyCallback {
        void onInvoke();
    }

    InterProxy(ProxyCallback callback) {
        this.callback = callback;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        if ("onReflect".equals(method.getName())) {
            callback.onInvoke();
        }

        return proxy;
    }
}