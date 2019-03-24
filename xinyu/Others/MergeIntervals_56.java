/*
* Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
*/
public class MergeIntervals_56 {
    /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */
// merged.isEmpty()-> 表示第一次
// 写算法的时候：要总结大规律 不要罗列小的具体情况 把握什么时候是 add 什么时候是merge
// comparator 接口
// 妙在根据start排序 解决了以end排序的问题 （以end排序最后不好merge [1,2][3,4],[5,6][1,10]）
    class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            intervals.sort(Comparator.comparingInt(o -> o.start));
            LinkedList<Interval> merged = new LinkedList<>();
            for (Interval interval : intervals)
                if (merged.isEmpty() || merged.getLast().end < interval.start)
                    merged.add(interval);
                else merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            return merged;
        }
    }
/*
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals.size() <= 1)return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
        @Override
        public int compare( Interval u1, Interval u2 ) {
        if ( u1.end < u2.end  ) {
            return -1;
        }
        else if(u1.end >u2.end){
            return 1;
        }
        else if(u1.start <u2.start){
            return 1;
        }else if (u1.start >u2.start){
            return -1;
        }else{
            return 0;
        }}});
        for(int i =1;i<intervals.size();i++){
            if(i ==1){
                if(intervals.get(0).end>=intervals.get(1).start) {
                if(intervals.get(0).start>intervals.get(1).start) result.add(intervals.get(1));
                else{
                   Interval inter = new Interval(intervals.get(0).start,intervals.get(1).end);
                   result.add(inter);
                }
            }
                else{
                result.add(intervals.get(0));
                result.add(intervals.get(1));
            }
            }
            else{
                if(intervals.get(i).start<= result.get(result.size()-1).end){
                    if(result.get(result.size()-1).start >=intervals.get(i).start) {
                        result.set(result.size()-1,intervals.get(i));
                       // result.get(result.size()-1) = intervals.get(i);
                    }
                    else{
                       Interval inter = new Interval(result.get(result.size()-1).start,intervals.get(i).end);
                        result.set(result.size()-1,inter);
                    }
                }
                else{
                result.add(intervals.get(i));
                }
            }
        }
    return result;
    }
}
*/
/*
private static class Person implements Comparable<Person>{
    int age;
    String name;
        ...
    /*
     * @desc 实现 “Comparable<String>” 的接口，即重写compareTo<T t>函数。
     *  这里是通过“person的名字”进行比较的
    @Override
    public int compareTo(Person person) {
        return name.compareTo(person.name);
        //return this.name - person.name;
    }
}
// 新建ArrayList(动态数组)
ArrayList<Person> list = new ArrayList<Person>();
// 添加对象到ArrayList中
list.add(new Person("ccc", 20));
list.add(new Person("AAA", 30));
list.add(new Person("bbb", 10));
list.add(new Person("ddd", 40));
Collections.sort(list);
*/

}
