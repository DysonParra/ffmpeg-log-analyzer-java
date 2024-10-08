/*
 * @fileoverview    {Application}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementation done.
 * @version 2.0     Documentation added.
 */
package com.project.dev;

import com.project.dev.flag.processor.Flag;
import com.project.dev.flag.processor.FlagProcessor;
import com.project.dev.log.LogProcessor;

/**
 * TODO: Description of {@code Application}.
 *
 * @author Dyson Parra
 * @since 11
 */
public class Application {

    /**
     * Entrada principal del sistema.
     *
     * @param args argumentos de la linea de comandos.
     */
    public static void main(String[] args) {
        System.out.println("\n...START...");

        String requiredFlags[][] = {
            {"-logsPath"},
            {"-ffmpegLogFilePath"},
            {"-outputPath"}
        };

        String optionalFlags[][] = {
        };

        String defaultArgs[] = {
            "-logsPath",
            "res\\log",
            "-ffmpegLogFilePath",
            "res\\ffmpeg.log",
            "-outputPath",
            "res\\output",
        };

        // for (String arg : args)
        //     System.out.println(arg);
        Flag[] flags;
        flags = FlagProcessor.convertArgsToFlags(args, defaultArgs, requiredFlags, optionalFlags, true);
        if (flags == null) {
            System.out.println("...ERROR IN FLAGS...");
            return;
        }

        FlagProcessor.printFlagsArray(flags, true);

        boolean result;
        result = LogProcessor.processFlags(flags);
        System.out.println("last result = " + result);
        System.out.println("...END...");
    }

}
