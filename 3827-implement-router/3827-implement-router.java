class Packet{
    int src , dest , tStamp;
    Packet(int src , int dest , int tStamp){
        this.src = src;
        this.dest = dest;
        this.tStamp = tStamp;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Packet p){
            return this.src==p.src && this.dest==p.dest && this.tStamp==p.tStamp;
        }
        return false;
        
    }
    @Override
    public int hashCode(){
        return Objects.hash(src,dest,tStamp);
    }
}


class Router {
    private int memoryLimit;
    private Deque<Packet> Queue;
    private Set<Packet> set;
    private Map<Integer, List<Integer>> destMap;
    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.Queue = new ArrayDeque<>();
        this.destMap = new HashMap<>();
        this.set = new HashSet<>();

    }
  
    public boolean addPacket(int source, int destination, int timestamp) {
            Packet p = new Packet(source,destination,timestamp);
            if(set.contains(p))return false;

            if(set.size()==memoryLimit){
                //means to remove the older packet 
                Packet del = Queue.pollFirst();
                //this packet entry of timestamp must be remvoe form the List<Integr> and set
                set.remove(del);
                List<Integer> timestamps = destMap.get(del.dest);
                int idx = lowerBound(timestamps,del.tStamp);
                timestamps.remove(idx);
                if(timestamps.isEmpty()){
                    destMap.remove(del.dest);
                }
            }

            Queue.addLast(p);
            set.add(p);
            destMap.merge(p.dest, new ArrayList<>(List.of(p.tStamp)), (a, b) -> {
                insertSorted(a, b.get(0)); // insert the single timestamp into the existing list
                return a;
            });
           

            
            return true;

    }
    
    public int[] forwardPacket() {
        if(Queue.isEmpty())return new int[0];

        Packet fwd = Queue.pollFirst();
        set.remove(fwd);
        List<Integer> timestamps = destMap.get(fwd.dest);
        int idx = lowerBound(timestamps,fwd.tStamp);
        timestamps.remove(idx);
        if(timestamps.isEmpty()){
                    destMap.remove(fwd.dest);
        }

        return new int[]{fwd.src, fwd.dest,fwd.tStamp};

    }
    
    public int getCount(int destination, int startTime, int endTime) {
         //this is important 
         if(!destMap.containsKey(destination))return 0;

         List<Integer> list = destMap.get(destination);

         int lo = lowerBound(list,startTime);
         int hi = upperBound(list,endTime);

         return hi-lo;


    }

    public static int lowerBound(List<Integer> list , int target){
          int n = list.size();
          int low = 0;
          int high = n;
          while(low<high){
              int mid = low+(high-low)/2;

              if(list.get(mid)>=target){
                 high = mid;
              }
              else{
                 low = mid+1;
              }
          }

          return low;
    }
    private void insertSorted(List<Integer> list, int value) {
        int idx = lowerBound(list, value);
        list.add(idx, value);
    }
    public static int upperBound(List<Integer> list , int target){
          int n = list.size();
          int low = 0;
          int high = n;
          while(low<high){
              int mid = low+(high-low)/2;

              if(list.get(mid)<=target){
                 low = mid+1;
              }
              else{
                 high = mid;
              }
          }

          return low;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */