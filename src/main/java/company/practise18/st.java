package company.practise18;

public class st{
    public int consume,num,target,ori;

    public int getConsume() {
        return consume;
    }

    public void setConsume(int consume) {
        this.consume = consume;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public void setOri(int ori) {
        this.ori = ori;
    }

    public int getNum() {
        return num;
    }

    public int getTarget() {
        return target;
    }

    public int getOri() {
        return ori;
    }

/*    @Override
    public int compareTo(st o) {
        if (this.consume != o.consume){
            return this.consume - o.consume;
        }
        if (this.num < o.num){
            return this.num - o.num;
        }

        return   o.ori - o.target;
    }*/
}
