package com.shabinder.jaudiotagger.audio.real;

import com.shabinder.jaudiotagger.audio.generic.GenericTag;
import com.shabinder.jaudiotagger.tag.FieldDataInvalidException;
import com.shabinder.jaudiotagger.tag.FieldKey;
import com.shabinder.jaudiotagger.tag.KeyNotFoundException;
import com.shabinder.jaudiotagger.tag.TagField;

public class RealTag extends GenericTag
{
    public String toString()
    {
        String output = "REAL " + super.toString();
        return output;
    }

    public TagField createCompilationField(boolean value) throws KeyNotFoundException, FieldDataInvalidException
    {
        return createField(FieldKey.IS_COMPILATION,String.valueOf(value));
    }
}
