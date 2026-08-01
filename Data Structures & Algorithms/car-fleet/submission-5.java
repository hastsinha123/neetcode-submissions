class Solution {

    static class Car {
        int pos;
        Double time;

        public Car(int p, double t){
            this.pos = p;
            this.time = t;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        for(int i=0;i<position.length;i++){
            cars[i] = new Car(position[i], ((double)(target - position[i])/speed[i]) );
        }

        Arrays.sort(cars, (Car a, Car b) -> {
            return (b.pos - a.pos);
        });

        Stack<Double> stack = new Stack<>();
        stack.push(cars[0].time);

        for(int i=0;i<cars.length;i++){
        
            System.out.println("BEF "+cars[i].time);
            if(stack.isEmpty() || cars[i].time > stack.peek()){
                
                stack.push(cars[i].time);
            }
        }
        for(Double d: stack){
            System.out.println(""+d);
        }
        return stack.size();
    }
}
