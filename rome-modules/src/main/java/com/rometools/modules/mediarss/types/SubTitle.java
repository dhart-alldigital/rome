/*
 * Copyright 2006 Nathanial X. Freitas, openvision.tv
 *
 * This code is currently released under the Mozilla Public License.
 * http://www.mozilla.org/MPL/
 *
 * Alternately you may apply the terms of the Apache Software License
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.rometools.modules.mediarss.types;

import java.io.Serializable;
import java.net.URI;

import com.rometools.rome.feed.impl.EqualsBean;
import com.rometools.rome.feed.impl.ToStringBean;

/**
 * <strong>&lt;media:thumbnail&gt;</strong></p>
 *
 *
 * <p>
 * Optional element for subtitle/CC link. It contains type and language attributes. Language is based on RFC 3066. There can be more than one such tag per media element, for example one per language. Please refer to Timed Text spec - W3C for more information on Timed Text and Real Time Subtitling.
 * </p>
 *
 * <pre>
 * &lt;media:subTitle type="application/smil" lang="en-us" href="http://www.example.org/subtitle.smil" /&gt;
 * </pre>
 * <p>
 * <em>type</em> specifies the mime type of the subtitle. It is a required attribute.
 * </p>
 * <p>
 * <em>lang</em> specifies the language of the subtitle. It is an optional attribute.
 * </p>
 * <p>
 * <em>href</em> specifies the url of the subtitle. It is an optional attribute.
 * </p>

 */
public class SubTitle implements Cloneable, Serializable {

	private static final long serialVersionUID = 8129381031949501120L;

	private String type = null;
    private String lang = null;
    private URI url = null;

    /**
     * @param url URL to thumbnail
     * @param width width in pixels
     * @param height height in pixels
     * @param time Timecode representing the thumbnails position in a source.
     */
    public SubTitle(final URI url, final String type, final String lang) {
    	this.url = url;
    	this.type = type;
    	this.lang = lang;
    }

    /**
     * @param url URL
     */
    public SubTitle(final URI url) {
        this(url, null, null);
    }

    /**
     *
     * Returns the type.
     *
     * @return Returns the type.
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the language.
     *
     * @return Returns the language.
     */
    public String getLang() {
        return lang;
    }

    /**
     *
     * Returns the URL
     *
     * @return Returns the subtitle url.
     */
    public URI getUrl() {
        return url;
    }


    @Override
    public Object clone() {
        return new SubTitle(url, type, lang);
    }

    @Override
    public boolean equals(final Object obj) {
        final EqualsBean eBean = new EqualsBean(this.getClass(), this);

        return eBean.beanEquals(obj);
    }

    @Override
    public int hashCode() {
        final EqualsBean equals = new EqualsBean(this.getClass(), this);

        return equals.beanHashCode();
    }

    @Override
    public String toString() {
        final ToStringBean tsBean = new ToStringBean(this.getClass(), this);

        return tsBean.toString();
    }
}
