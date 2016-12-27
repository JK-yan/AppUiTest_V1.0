/**
 * Created by admin on 2016/12/27.
 */
public class gsontest {
    private String _id;
    private String id;
    private String url;
    private ReqHeader reqHeader;

    public class ReqHeader{
        private String host;
        private String proxyconnection;

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getProxyconnection() {
            return proxyconnection;
        }

        public void setProxyconnection(String proxyconnection) {
            this.proxyconnection = proxyconnection;
        }
        @Override
        public String toString(){
            return "reqHeader:[host="+host+",proxyconnection="+proxyconnection+"]";
        }
    }
    @Override
    public String toString(){
        return "gsontest:[_id="+_id+",id+"+id+",ur=l"+url+",reqHeader="+reqHeader+"]";
    }

}
