package fablab.devinci.myfabconnect;

import java.util.List;

/**
 * Created by Ken on 22/07/2017.
 */

public class Project {

    private List<ItemsBean> items;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * id : 129
         * userid : 34
         * memberid : 34
         * title : FactoryECO
         * scope : Maquette
         * type : Projet Fun
         * conf : Pièce Unique
         * status : 100
         * datecreated : 2017-03-01
         * dateover : 0000-00-00
         * googleid : 0B37vVH0j3idBZnpYUnZzODhPVFE
         */

        private String id;
        private String userid;
        private String memberid;
        private String title;
        private String scope;
        private String type;
        private String conf;
        private String status;
        private String datecreated;
        private String dateover;
        private String googleid;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getMemberid() {
            return memberid;
        }

        public void setMemberid(String memberid) {
            this.memberid = memberid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getConf() {
            return conf;
        }

        public void setConf(String conf) {
            this.conf = conf;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDatecreated() {
            return datecreated;
        }

        public void setDatecreated(String datecreated) {
            this.datecreated = datecreated;
        }

        public String getDateover() {
            return dateover;
        }

        public void setDateover(String dateover) {
            this.dateover = dateover;
        }

        public String getGoogleid() {
            return googleid;
        }

        public void setGoogleid(String googleid) {
            this.googleid = googleid;
        }
    }
}
