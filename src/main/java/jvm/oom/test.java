package jvm.oom;

public class test {
    public static void main(String[] args) {
        // 虚拟机的总内存--初始内存
        double v1 = Runtime.getRuntime().totalMemory() / 1024.0 / 1024.0;
        // 虚拟机试图使用的最大内存
        double v = Runtime.getRuntime().maxMemory() / 1024.0 / 1024.0;

        System.out.printf("虚拟机的总内存--初始内存: %f m",v1);
        System.out.printf("虚拟机试图使用的最大内存: %f m",v);
        System.out.println();
        doWhile();

    }

    public static void doWhile(){
        String s="123";
        while (true){
            s=s+"341231231231231312312312312312312312312312312312313123123121123125";
        }
    }
}
