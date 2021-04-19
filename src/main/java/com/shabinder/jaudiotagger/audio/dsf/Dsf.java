package com.shabinder.jaudiotagger.audio.dsf;

import com.shabinder.jaudiotagger.tag.Tag;
import com.shabinder.jaudiotagger.tag.TagOptionSingleton;
import com.shabinder.jaudiotagger.tag.id3.ID3v22Tag;
import com.shabinder.jaudiotagger.tag.id3.ID3v23Tag;
import com.shabinder.jaudiotagger.tag.id3.ID3v24Tag;
import com.shabinder.jaudiotagger.tag.reference.ID3V2Version;

/**
 * Created by Paul on 28/01/2016.
 */
public class Dsf
{
    public static Tag createDefaultTag()
    {
        if(TagOptionSingleton.getInstance().getID3V2Version()== ID3V2Version.ID3_V24)
        {
            return new ID3v24Tag();
        }
        else if(TagOptionSingleton.getInstance().getID3V2Version()==ID3V2Version.ID3_V23)
        {
            return new ID3v23Tag();
        }
        else if(TagOptionSingleton.getInstance().getID3V2Version()==ID3V2Version.ID3_V22)
        {
            return new ID3v22Tag();
        }
        //Default in case not set somehow
        return new ID3v24Tag();
    }
}
