package com.shabinder.jaudiotagger.audio.mp3;

import com.shabinder.jaudiotagger.audio.AudioFile;
import com.shabinder.jaudiotagger.audio.exceptions.CannotReadException;
import com.shabinder.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import com.shabinder.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import com.shabinder.jaudiotagger.audio.generic.AudioFileReader;
import com.shabinder.jaudiotagger.audio.generic.GenericAudioHeader;
import com.shabinder.jaudiotagger.tag.Tag;
import com.shabinder.jaudiotagger.tag.TagException;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Read Mp3 Info (retrofitted to entagged ,done differently to entagged which is why some methods throw RuntimeException)
 * because done elsewhere
 */
public class MP3FileReader extends AudioFileReader
{
    protected GenericAudioHeader getEncodingInfo(RandomAccessFile raf) throws CannotReadException, IOException
    {
        throw new RuntimeException("MP3FileReader.getEncodingInfo should be called");
    }

    protected Tag getTag(RandomAccessFile raf) throws CannotReadException, IOException
    {
        throw new RuntimeException("MP3FileReader.getEncodingInfo should be called");
    }

    /**
     * @param f
     * @return
     */
    //Override because we read mp3s differently to the entagged code
    public AudioFile read(File f) throws IOException, TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException
    {
        MP3File mp3File = new MP3File(f, MP3File.LOAD_IDV1TAG | MP3File.LOAD_IDV2TAG, true);
        return mp3File;
    }

    /**
     * Read
     *
     * @param f
     * @return
     * @throws ReadOnlyFileException thrown if the file is not writable
     * @throws TagException
     * @throws IOException
     * @throws com.shabinder.jaudiotagger.audio.exceptions.InvalidAudioFrameException
     */
    public AudioFile readMustBeWritable(File f) throws IOException, TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException
    {
        MP3File mp3File = new MP3File(f, MP3File.LOAD_IDV1TAG | MP3File.LOAD_IDV2TAG, false);
        return mp3File;
    }

}
