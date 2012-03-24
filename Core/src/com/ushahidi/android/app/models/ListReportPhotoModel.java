/**
 ** Copyright (c) 2010 Ushahidi Inc
 ** All rights reserved
 ** Contact: team@ushahidi.com
 ** Website: http://www.ushahidi.com
 **
 ** GNU Lesser General Public License Usage
 ** This file may be used under the terms of the GNU Lesser
 ** General Public License version 3 as published by the Free Software
 ** Foundation and appearing in the file LICENSE.LGPL included in the
 ** packaging of this file. Please review the following information to
 ** ensure the GNU Lesser General Public License version 3 requirements
 ** will be met: http://www.gnu.org/licenses/lgpl.html.
 **
 **
 ** If you have questions regarding the use of this file, please contact
 ** Ushahidi developers at team@ushahidi.com.
 **
 **/

package com.ushahidi.android.app.models;

import java.util.ArrayList;
import java.util.List;

import com.ushahidi.android.app.database.Database;
import com.ushahidi.android.app.entities.Media;

/**
 * @author eyedol
 */
public class ListReportPhotoModel extends Model {

    private int id;

    private String photo;

    private List<Media> mMedia;

    private List<ListReportPhotoModel> mPhotoModel;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /*
     * (non-Javadoc)
     * @see com.ushahidi.android.app.models.Model#load(android.content.Context)
     */
    @Override
    public boolean load() {
        return false;
    }

    public boolean load(int reportId) {
        mMedia = Database.mMediaDao.fetchReportPhoto(reportId);
        if(mMedia != null) {
        	return true;
        }
        return false;
    }

    public List<ListReportPhotoModel> getPhotos() {
        mPhotoModel = new ArrayList<ListReportPhotoModel>();

        if (mMedia != null && mMedia.size() > 0) {
            for (Media item : mMedia) {
                ListReportPhotoModel photoModel = new ListReportPhotoModel();
                photoModel.setId(item.getDbId());
                photoModel.setPhoto(item.getLink());
                mPhotoModel.add(photoModel);
            }
        }

        return mPhotoModel;
    }

    /*
     * (non-Javadoc)
     * @see com.ushahidi.android.app.models.Model#save(android.content.Context)
     */
    @Override
    public boolean save() {
        // TODO Auto-generated method stub
        return false;
    }

}