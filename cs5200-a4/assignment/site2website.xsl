<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" indent="yes" />
	<xsl:template match="@*|node()">
		<xsl:copy>
			<xsl:apply-templates select="@*|node()" />
		</xsl:copy>
	</xsl:template>
	<xsl:template match="/">
		<site>
			<xsl:attribute id="@id"><xsl:value-of select="@id" /></xsl:attribute>
			<xsl:attribute name="@name"><xsl:value-of select="@name" /></xsl:attribute>
			<xsl:apply-templates />
		</site>
	</xsl:template>
	<xsl:template match="site">
		<website>
			<xsl:apply-templates select="@*|node()" />
		</website>
	</xsl:template>
	<xsl:template match="site/views">
		<views>
			<xsl:apply-templates />
		</views>
		<pages>
			<xsl:apply-templates select="@*|node()" />
		</pages>
	</xsl:template>

	<xsl:template match="site/views/view">
		<view>
			<xsl:attribute id="id"><xsl:value-of select="@id" /></xsl:attribute>
			<xsl:attribute name="name"><xsl:value-of select="@name" /></xsl:attribute>
			<description>
				<xsl:attribute desc="description"><xsl:value-of select="description" /></xsl:attribute>
			</description>
			<component>
				<xsl:attribute ref="ref"><xsl:value-of select="@ref" /></xsl:attribute>
			</component>
		</view>
		<page>
			<xsl:apply-templates select="@*|node()" />
		</page>
	</xsl:template>


	<xsl:template match="site/components">
		<components>
			<xsl:apply-templates />
		</components>
	</xsl:template>

	<xsl:template match="site/components/component">
		<component>
			<xsl:attribute id="id"><xsl:value-of select="@id" /></xsl:attribute>
			<xsl:attribute type="type"><xsl:value-of select="@type" /></xsl:attribute>
			<xsl:attribute type="src"><xsl:value-of select="@src" /></xsl:attribute>
			<xsl:attribute type="url"><xsl:value-of select="@url" /></xsl:attribute>
			<xsl:attribute type="label"><xsl:value-of select="@label" /></xsl:attribute>
			<text>
				<xsl:attribute desc="text"><xsl:value-of select="text" /></xsl:attribute>
			</text>
		</component>
		<widget>
			<xsl:apply-templates select="@*|node()" />
		</widget>
	</xsl:template>

</xsl:stylesheet>
