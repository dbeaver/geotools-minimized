/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2019, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 *
 */

package org.jkiss.geotools.mssql;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.CoordinateSequence;

/**
 * Represents the information from a binary sqlserver geometry
 *
 * @author Anders Bakkevold, Bouvet
 */
class SqlServerBinary {

    private int srid;
    private int numberOfPoints;
    private Coordinate[] coordinates;
    private Shape[] shapes;
    private Figure[] figures;
    private CoordinateSequence[] sequences;

    public int getSrid() {
        return srid;
    }

    public void setSrid(int srid) {
        this.srid = srid;
    }

    public void setSerializationProperties(byte serializationProperties) {
        this.serializationProperties = serializationProperties;
    }

    public boolean hasZ() {
        return (serializationProperties & 1) == 1;
    }

    public boolean hasM() {
        return (serializationProperties & 2) == 2;
    }

    public boolean isValid() {
        return (serializationProperties & 4) == 4;
    }

    public boolean isSinglePoint() {
        return (serializationProperties & 8) == 8;
    }

    public boolean hasSingleLineSegment() {
        return (serializationProperties & 16) == 16;
    }

    private byte serializationProperties;

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public Coordinate[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinate[] coordinates) {
        this.coordinates = coordinates;
    }

    public void setShapes(Shape[] shapes) {
        this.shapes = shapes;
    }

    public void setFigures(Figure[] figures) {
        this.figures = figures;
    }

    public Figure[] getFigures() {
        return figures;
    }

    public void setSequences(CoordinateSequence[] sequences) {
        this.sequences = sequences;
    }

    public Shape[] getShapes() {
        return shapes;
    }

    public Shape getShape(int index) {
        return shapes[index];
    }

    public Figure getFigure(int index) {
        return figures[index];
    }

    public CoordinateSequence getSequence(int index) {
        return sequences[index];
    }
}
