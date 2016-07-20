package com.accunity.reusable.model;


import com.adobe.cq.sightly.WCMUse;
import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.JSONObject;
import javax.jcr.*;
import java.util.ArrayList;
import java.util.List;

public class FooterListings extends WCMUse {

    private FooterListingsModel footerListingsModel = null;
    private List<FooterListingsModel> footerListingsModelList = null;
    public List<FooterListingsModel> getFooterListingsModelList() {
        return footerListingsModelList;
    }




    @Override
    public void activate() throws Exception {
        footerListingsModelList = new ArrayList<FooterListingsModel>();
        Node currentNode = getResource().adaptTo(Node.class);
        String currentItem = "iItems";
        if(currentNode.hasProperty(currentItem)){
            setItems(currentNode, currentItem);
        }
    }

    private void setItems(Node currentNode, String tab)
            throws PathNotFoundException, RepositoryException, ValueFormatException, JSONException {
        Value[] value;
        JSONObject jObj;
        Property currentProperty;
        currentProperty = currentNode.getProperty(tab);
        if(currentProperty.isMultiple()){
            value = currentProperty.getValues();
        }else{
            value = new Value[1];
            value[0] = currentProperty.getValue();
        }
        for (int i = 0; i < value.length; i++) {
            jObj = new JSONObject(value[i].getString());
            footerListingsModel = new FooterListingsModel();
            footerListingsModel.setPage(jObj.getString("page"));
            footerListingsModel.setPath(jObj.getString("path"));
            footerListingsModelList.add(footerListingsModel);
        }
    }
    public class FooterListingsModel{
        private String page;
        private String path;
        public String getPage() {
            return page;
        }
        public void setPage(String page) {
            this.page = page;
        }
        public String getPath() {
            return path;
        }
        public void setPath(String path) {
            this.path = path;
        }
    }
}
