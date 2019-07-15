<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h1>Client ID / Balance</h1>
                <table border="1">
                    <tr>
                        <th>Client ID</th>
                        <th>Balance</th>
                    </tr>
                    <xsl:for-each select="clients/client">
                        <tr>
                            <td>
                                <xsl:value-of select="idClient"/>
                            </td>
                            <td>
                                <xsl:value-of select="balance"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>