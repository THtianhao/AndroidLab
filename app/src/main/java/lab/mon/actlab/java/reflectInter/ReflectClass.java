package lab.mon.actlab.java.reflectInter;


class ReflectClass {

    interface ReflectInter {
        public void onReflect();
    }

    public ReflectInter inter = null;

    void addInter(ReflectInter reflectInter) {
        inter = reflectInter;
        invoInter();
    }



    private void invoInter() {
        inter.onReflect();
    }


}
