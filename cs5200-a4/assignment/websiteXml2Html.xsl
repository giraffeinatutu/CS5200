<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	  <xsl:output method="html"/> 
	<xsl:template match="/">
		<html>
			<body>
				<h1>Website</h1>
				<h2>Pages</h2>
				<xsl:for-each select="website/page">
					<xsl:number value="position()" format="1" />
					<xsl:text>. </xsl:text>
					<xsl:value-of select="@name" />
					<xsl:text>, </xsl:text>
					<xsl:value-of select="description" />
					<br />
				</xsl:for-each>
				<h2>Widgets</h2>
				<table border="1">
					<tr bgcolor="#ff0066">
						<th>id</th>
						<th>type</th>
						<th>text</th>
						<th>src</th>
						<th>url</th>
						<th>label</th>
					</tr>
					<xsl:for-each select="website/page/widget">
						<tr>
							<td>
								<xsl:value-of select="@id" />
							</td>
							<td>
								<xsl:value-of select="@type" />
							</td>
							<td>
								<xsl:value-of select="@text" />
							</td>
							<td>
								<xsl:value-of select="@src" />
							</td>
							<td>
								<xsl:value-of select="@url" />
							</td>
							<td>
								<xsl:value-of select="@label" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>