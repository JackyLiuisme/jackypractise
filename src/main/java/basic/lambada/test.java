package basic.lambada;

public class test {
    public static void main(String[] args) throws InterruptedException {

      /*  List<Dish> list = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                 new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

        List<String> name = list.stream().filter(d -> d.getCalories() < 400).
                sorted(comparing(Dish::getCalories)).map(Dish::getName).collect(Collectors.toList());
        for (String  string:name
             ) {
            System.out.println(string);
        }*/
        /*EventExecutor eventExecutor = new DefaultEventExecutor();
        Promise promise = new DefaultPromise(eventExecutor);
        promise.addListener(new GenericFutureListener<Future<Integer>>() {
            @Override
            public void operationComplete(Future future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("overed" + future.get());
                } else {
                    System.out.println("faired" + future.get());
                }
            }
        }).addListener(new GenericFutureListener<Future<Integer>>() {
            @Override
            public void operationComplete(Future future) throws Exception {
                System.out.println("finished");
            }
        });
        eventExecutor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                promise.setSuccess(123456);
            }
        });
        promise.await();
    }*/
        System.out.println(3 & -3);
    }
}
